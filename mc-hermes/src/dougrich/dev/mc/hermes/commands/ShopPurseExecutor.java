package dougrich.dev.mc.hermes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopPurseExecutor extends ShopBaseCommandExecutor {

    protected ShopExecutorArgs tryGetArgs(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if(!(sender instanceof Player)) {
            // Server cannot send this command.
            return null;
        }

        if(!(args.length == 1 && args[0].equalsIgnoreCase("purse"))) {
            // This is not the purse command.
            return null;
        }

        // Success case; create and return parsed arguments.
        final ShopExecutorArgs parsedArgs = new ShopExecutorArgs();
        parsedArgs.sender = sender;
        parsedArgs.commandtype = ShopCommandType.PURSE;
        return parsedArgs;
    }

    protected boolean handleCommand(final ShopExecutorArgs e) {
        if(!(e.sender instanceof Player)) {
            // Server cannot send this command.
            return false;
        }

        if(e.commandtype != ShopCommandType.PURSE) {
            // These are not arguments for the PURSE command.
            return false;
        }

        // TODO: send player purse information.
        // use player.getName as key in database?
        e.sender.sendMessage("TODO: send player purse information");
        return true;
    }
}