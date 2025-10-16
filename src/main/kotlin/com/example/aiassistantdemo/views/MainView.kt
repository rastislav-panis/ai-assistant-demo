package com.example.aiassistantdemo.views

import com.example.aiassistantdemo.service.ChatService
import com.vaadin.flow.component.messages.MessageInput
import com.vaadin.flow.component.messages.MessageList
import com.vaadin.flow.component.messages.MessageListItem
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouteAlias
import io.github.oshai.kotlinlogging.KotlinLogging
import java.time.Instant
import java.util.Locale

@PageTitle("Chat")
@Route(value = "assistant")
@RouteAlias(value = "")
class MainView(val chatService: ChatService) : VerticalLayout() {
    private val chat: MessageList = MessageList()
    private val input: MessageInput = MessageInput()

    companion object {
        private val logger = KotlinLogging.logger {}
        private const val USER_AVATAR = "https://api.dicebear.com/6.x/big-ears-neutral/svg?seed=Molly"
        private const val AI_AVATAR = "https://api.dicebear.com/6.x/bottts/svg?seed=Sophie"
        private const val SYSTEM_AVATAR = "https://api.dicebear.com/6.x/bottts/svg?seed=Sheba"
    }

    init {
        add(chat, input)

        // Full-size center and add padding
        this.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, chat, input)
        this.isPadding = true // Leave some white space
        this.setHeightFull() // We maximize to window
        chat.setSizeFull() // Chat takes most of the space
        chat.isMarkdown = true
        chat.maxWidth = "800px" // Until to a certain size
        input.setWidthFull() // Full width only
        input.maxWidth = "800px" // Until to a certain size
        input.addSubmitListener { submitEvent -> this.onSubmit(submitEvent) }

        // Focus input after loading history to ensure cursor is in the message box
        input.focus()
    }

    private fun onSubmit(submitEvent: MessageInput.SubmitEvent) {
        // Append an item (this will be overridden later when the reply comes)
        val items = mutableListOf<MessageListItem>()
        items.addAll(chat.items)
        val inputItem = MessageListItem(submitEvent.value, Instant.now(), formatName("user"), getAvatar("user"))
        items.add(inputItem)
        chat.setItems(items)

        val response = chatService.chat(submitEvent.value)
        ui.get().access {
            // Append the AI response
            val updatedItems = mutableListOf<MessageListItem>()
            updatedItems.addAll(chat.items)
            val aiItem =
                MessageListItem(response, Instant.now(), formatName("assistant"), getAvatar("assistant"))
            updatedItems.add(aiItem)
            chat.setItems(updatedItems)
        }
    }

    @Suppress("ReturnCount")
    private fun getAvatar(role: String) =
        when (role) {
            "assistant" -> AI_AVATAR
            "user" -> USER_AVATAR
            else -> SYSTEM_AVATAR
        }

    private fun formatName(role: String): String? {
        return if (role.isNotEmpty()) {
            role.substring(0, 1).uppercase(Locale.getDefault()) + role.substring(1)
        } else {
            role
        }
    }
}
