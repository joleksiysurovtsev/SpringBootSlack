package o.sur.example.services

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.api.model.Attachment
import com.github.seratch.jslack.api.webhook.Payload
import com.github.seratch.jslack.api.webhook.WebhookResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.IOException


@Service
class SlackService(
    @Value("\${slack.channel-name}") private val channelName: String? = null,
    @Value("\${slack.webhook}") private val webhookId: String? = null
) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    private val webhook = "https://hooks.slack.com/services/$webhookId"
    fun sendMessageToSlack(message: String) {
        val messageBuider = StringBuilder()
        messageBuider.append(message + "\n")
        process(messageBuider.toString())
    }

    private fun process(message: String) {
        val payload: Payload = Payload.builder().attachments(
            listOf(
                Attachment.builder().channelName("#$channelName").build()
            )
        ).text(message).build()
        try {
            val webhookResponse: WebhookResponse = Slack.getInstance().send(webhook, payload)
            if (webhookResponse.getCode() === 200) logger.info("Success send slack !")
            logger.info(webhookResponse.getMessage())
        } catch (e: IOException) {
            logger.error("Unexpected Error! WebHook:$webhook")
        }
    }
}