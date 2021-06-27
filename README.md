# DiscordBotUtils
Easy to use utils for Discord JDA. Includes command system and embed message builder

## How to create your own command
Create a new class and make it extend CustomCommand
```java
public class TestCommand extends CustomCommand {
    public TestCommand() {
        super("test", new String[]{"testing", "trail"}, new Permission[] {});
    }

    @Override
    public void execute(MessageReceivedEvent event, Member member, MessageChannel messageChannel, String[] args) {
        // place code here
    }
}
```

Then to register the command in the CommandHandler class following the example or you can register it in your main class
