package o.sur.example.controller

import o.sur.example.services.SlackService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class RestControllers(val service: SlackService) {

    @PostMapping(value = ["/test"])
    fun postMsg(msg: String){
        service.sendMessageToSlack(msg)
    }
}