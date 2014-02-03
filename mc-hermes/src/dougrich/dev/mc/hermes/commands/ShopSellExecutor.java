package dougrich.dev.mc.hermes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopSellExecutor extends ShopBaseCommandExecutor {

    protected enum SellType {
        HELD,
        ITEM_ID
    }

    protected class ShopSellExecutorArgs extends ShopExecutorArgs {
        public SellType type;
        public String item;
    }

    protected ShopExecutorArgs tryGetArgs(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if(args.length != 2) {
            // This command has the wrong number of arguments.
            return null;
        }

        if(args[0].equalsIgnoreCase("sell")) {
            // This is not the buy command.
            return null;
        }

        // Success case; create buy command parsed arguments and return.
        final ShopSellExecutorArgs parsedArgs = new ShopSellExecutorArgs();
        parsedArgs.sender = sender;
        parsedArgs.commandtype = ShopCommandType.SELL;

        if(args[1].equalsIgnoreCase("held")) {
            parsedArgs.type = SellType.HELD;
        }
        else {
            parsedArgs.type = SellType.ITEM_ID;
            parsedArgs.item = args[1];
        }

        return parsedArgs;
    }

    protected boolean handleCommand(final ShopExecutorArgs e) {
        if(!(e.sender instanceof Player)) {
            // Server cannot send this command.
            return false;
        }

        if(!(e instanceof ShopSellExecutorArgs)) {
            // These are not arguments for the buy command.
            return false;
        }

        // TODO: implement buy command.
        e.sender.sendMessage("TODO: implement sell command");
        return true;
    }
}