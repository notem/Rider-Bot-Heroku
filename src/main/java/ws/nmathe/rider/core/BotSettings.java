package ws.nmathe.rider.core;

/**
 * contains configurable variables for the bot
 */
public class BotSettings
{
    public String getToken()
    {
        return System.getenv().get("BOT_TOKEN");
    }

    public String getWebToken()
    {
        return System.getenv().get("WEB_TOKEN");
    }

    public String getAdminId()
    {
        return System.getenv().get("ADMIN_ID");
    }

    public String getCommandPrefix()
    {
        return System.getenv().get("PREFIX");
    }

    public String getAdminPrefix()
    {
        return System.getenv().get("ADMIN_PREFIX");
    }

    public String getChannel()
    {
        return System.getenv().get("CHANNEL");
    }

    public Integer getExpire()
    {
        Integer expire = 0;
        String expireProp = System.getenv().get("EXPIRE");
        String temp = "0";
        for( int i = 0; i < expireProp.length(); i++)
        {
            if( Character.isDigit( expireProp.charAt(i) ) )
            {
                temp += expireProp.charAt(i);
            }
            else
            {
                switch (expireProp.charAt(i))
                {
                    case 's' :
                        expire += Integer.parseInt(temp);
                        break;
                    case 'm' :
                        expire += 60 * Integer.parseInt(temp);
                        break;
                    case 'h' :
                        expire += 60*60 * Integer.parseInt(temp);
                        break;
                    case 'd' :
                        expire += 60*60*24 * Integer.parseInt(temp);
                        break;
                    case 'w' :
                        expire += 60*60*24*7 * Integer.parseInt(temp);
                        break;
                    default :
                        return expire;
                }
                temp = "0";
            }
        }
        return expire;
    }
}
