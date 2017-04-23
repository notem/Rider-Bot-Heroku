package ws.nmathe.rider.utils;

import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import ws.nmathe.rider.Main;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 */
public class HttpUtilities
{
    private static LocalDateTime lastUpdate = LocalDateTime.MIN;

    public static void updateCount(int i, String auth)
    {
        if (lastUpdate.until(LocalDateTime.now(), ChronoUnit.SECONDS) > 60)
        {
            JSONObject json = new JSONObject().put("server_count", i);

            Unirest.post("https://bots.discord.pw/api/bots/" + Main.getBotJda().getSelfUser().getId() + "/stats")
                    .header("Authorization", auth)
                    .header("Content-Type", "application/json")
                    .body(json);
        }
    }
}
