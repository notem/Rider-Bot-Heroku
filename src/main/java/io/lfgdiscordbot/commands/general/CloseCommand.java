package io.lfgdiscordbot.commands.general;

import io.lfgdiscordbot.Main;
import io.lfgdiscordbot.commands.Command;
import io.lfgdiscordbot.core.group.GroupTable;
import io.lfgdiscordbot.utils.__out;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

/**
 */
public class CloseCommand implements Command
{
    private static final String USAGE_BRIEF = "**;close** - removes the user's LFG entry";
    private static final String USAGE_EXTENDED = "";

    private String chanName = Main.getBotSettings().getChannel();

    @Override
    public String help(boolean brief)
    {
        if( brief )
            return USAGE_BRIEF;
        else
            return USAGE_BRIEF + "\n" + USAGE_EXTENDED;
    }

    @Override
    public String verify(String[] args, MessageReceivedEvent event)
    {
        return "";
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event)
    {
        GroupTable gTable = Main.getGroupManager().getGroupTable( event.getGuild().getId() );

        if( gTable.isAnOwner( event.getAuthor().getId() ) )
        {
            gTable.removeGroup( event.getAuthor().getId() );
        }

        Guild guild = event.getGuild();
        Member member = guild.getMember(event.getAuthor());

        List<Role> roles = guild.getRolesByName(chanName, true);
        if( !roles.isEmpty() && guild.getMember(Main.getBotSelfUser()).hasPermission(Permission.MANAGE_ROLES) )
        {
            try
            {
                guild.getController().removeRolesFromMember(member, roles.get(0)).queue();
            }
            catch( Exception e )
            {
                __out.printOut(this.getClass(), e.getMessage());
            }
        }
    }
}
