package dougrich.dev.mc.hermes.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ShopBuyExecutor extends ShopBaseCommandExecutor {

    protected class ShopBuyExecutorArgs extends ShopExecutorArgs {
        public String item;
        public int num;
    }

    protected ShopExecutorArgs tryGetArgs(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if(args.length != 3) {
            // This command has the wrong number of arguments.
            return null;
        }

        if(!args[0].equalsIgnoreCase("buy")) {
            // This is not the buy command.
            return null;
        }

        // Success case; create buy command parsed arguments and return.
        final ShopBuyExecutorArgs parsedArgs = new ShopBuyExecutorArgs();
        parsedArgs.sender = sender;
        parsedArgs.commandtype = ShopCommandType.BUY;
        parsedArgs.item = args[1];
        parsedArgs.num = Integer.parseInt(args[2]);
        return parsedArgs;
    }

    protected boolean handleCommand(final ShopExecutorArgs e) {
        if(!(e.sender instanceof Player)) {
            // Server cannot send this command.
            return false;
        }

        if(!(e instanceof ShopBuyExecutorArgs)) {
            // These are not arguments for the buy command.
            return false;
        }

        final ShopBuyExecutorArgs args = (ShopBuyExecutorArgs) e;
        final Player player = (Player) args.sender;

        // TODO: implement buy command.
        player.sendMessage("TODO: implement buy command");

        final Material material = Material.getMaterial(args.item);
        if(material == null) {
            return false;
        }

        final int stacks = args.num / 64;
        final ItemStack fullStack = new ItemStack(material, args.num / 64);
        final ItemStack remainderStack = new ItemStack(material, args.num % 64);
        for(int i = 0; i < stacks; i++) {
            player.getInventory().addItem(fullStack);
        }
        player.getInventory().addItem(remainderStack);

        return true;
    }
}