package ws.nmathe.rider.core;

/**
 * contains configurable variables for the bot
 */
public class BotSettings
{
    private final static String DEFAULT_TOKEN = "none";
    private final static String DEFAULT_WEB_TOKEN = "none";
    private final static String DEFAULT_ADMIN = "none";
    private final static String DEFAULT_PREFIX = ":";
    private final static String DEFAULT_ADMIN_PREFIX = ".";
    private final static String DEFAULT_CHANNEL_NAME = "lfg";
    private final static String DEFAULT_EXPIRE = "1h";
    private final static long DEFAULT_COOLDOWN = 2000;

    public String getToken()
    {
        if(System.getenv().get("BOT_TOKEN") == null)
        {
            return DEFAULT_TOKEN;
        }
        return System.getenv().get("BOT_TOKEN");
    }

    public String getWebToken()
    {
        if(System.getenv().get("WEB_TOKEN") == null)
        {
            return DEFAULT_WEB_TOKEN;
        }
        return System.getenv().get("WEB_TOKEN");
    }

    public String getAdminId()
    {
        if(System.getenv().get("ADMIN_ID") == null)
        {
            return DEFAULT_ADMIN;
        }
        return System.getenv().get("ADMIN_ID");
    }

    public String getCommandPrefix()
    {
        if(System.getenv().get("PREFIX") == null)
        {
            return DEFAULT_PREFIX;
        }
        return System.getenv().get("PREFIX");
    }

    public String getAdminPrefix()
    {
        if(System.getenv().get("ADMIN_PREFIX") == null)
        {
            return DEFAULT_ADMIN_PREFIX;
        }
        return System.getenv().get("ADMIN_PREFIX");
    }

    public String getChannel()
    {
        if(System.getenv().get("CHANNEL") == null)
        {
            return DEFAULT_CHANNEL_NAME;
        }
        return System.getenv().get("CHANNEL");
    }

    public long getCooldownThreshold()
    {
        if(System.getenv().get("COOLDOWN") == null)
        {
            return DEFAULT_COOLDOWN;
        }
        return Integer.parseUnsignedInt(System.getenv().get("COOLDOWN"));
    }

    public Integer getExpire()
    {
        String expireProp;
        Integer expire = 0;
        if(System.getenv().get("EXPIRE") == null)
        {
            expireProp = DEFAULT_EXPIRE;
        }
        else
        {
            expireProp = System.getenv().get("EXPIRE");
        }
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
