/**
  * Based on https://discord4j.readthedocs.io/en/latest/Command-structures/?highlight=BotUtils
  */

import sx.blah.discord.api.{ClientBuilder, IDiscordClient}
import sx.blah.discord.handle.obj.IChannel
import sx.blah.discord.util.{DiscordException, RequestBuffer}
import sx.blah.discord.util.RequestBuffer.IVoidRequest

object BotUtils {
    val BOT_PREFIX = "."

    def getBuiltDiscordClient(token: String): IDiscordClient = {
        new ClientBuilder().withToken(token).build()
    }

    def sendMessage(channel: IChannel, message: String): Unit = {

        // This might look weird but it'll be explained in another page.

        RequestBuffer.request((() => {
            try{
                channel.sendMessage(message)
            } catch {
                case _: DiscordException =>
                    System.err.println("Message could not be sent with error: ")
            }
        }).asInstanceOf[IVoidRequest])


    }

}
