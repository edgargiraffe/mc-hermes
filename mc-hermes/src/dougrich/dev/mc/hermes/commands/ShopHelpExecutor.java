package dougrich.dev.mc.hermes.commands;

public class ShopHelpExecutor extends ShopBaseCommandExecutor {

    protected boolean handleCommand(final ShopExecutorArgs e) {
        final String[] help = {
                "----MC-Hermes Help----",
                "/shop help: displays shop message",
                "/shop purse: gives information about your purse",
                "/shop list <minecraft:id>: lists items for sale",
                "/shop buy <minecraft:id> <number>: attempts to buy from your purse",
                "/shop sell <held|minecraft:id>: adds an item to circulation",
        };
        e.sender.sendMessage(help);
        return true;
    }
}
