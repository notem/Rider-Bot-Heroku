# Rider-Bot-Heroku
## Conversion of Rider-Bot to be deployable on a heroku instance

### Deployment
Review heroku's [Java application deployment guide](https://devcenter.heroku.com/articles/getting-started-with-java#introduction)
+ Login to heroku cli ``heroku login``
+ Clone this repo ``git clone https://github.com/notem/Rider-Bot-Heroku.git; cd Rider-Bot-Heroku``
+ Create the heroku instance ``heroku create; git push heroku master``
+ Set environment config variables
    + ``heroku config:set BOT_TOKEN="[your bot token]"``
    + ``heroku config:set WEB_TOKEN="none"``
    + ``heroku config:set ADMIN_ID="[your discord ID]"``
    + ``heroku config:set PREFIX=":"``
    + ``heroku config:set ADMIN_PREFIX="."``
    + ``heroku config:set CHANNEL="lfg"``
    + ``heroku config:set EXPIRE="1h"``
    + ``heroku config:set COOLDOWN="1000"``
    + Alternatively, the above can be setup through the heroku web interface
+ Start the application ``heroku ps:scale run=1``

### Dependencies

+ [JDA](https://github.com/DV8FromTheWorld/JDA) - 3.0.BETA2 Build:108
+ [Unirest](https://github.com/Mashape/unirest-java) - 1.4.9
