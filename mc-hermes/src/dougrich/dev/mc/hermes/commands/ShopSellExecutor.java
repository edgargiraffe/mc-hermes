package dougrich.dev.mc.hermes.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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

        if(!args[0].equalsIgnoreCase("sell")) {
            // This is not the buy command.
            return null;
        }

        // Success case; create buy command parsed arguments and return.
        final ShopSellExecutorArgs parsedArgs = new ShopSellExecutorArgs();
        parsedArgs.sender = sender;

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

        final ShopSellExecutorArgs args = (ShopSellExecutorArgs) e;
        final Player player = (Player) args.sender;

        // TODO: implement buy command.
        player.sendMessage("TODO: implement sell command.");
        player.sendMessage("currently removing item from inventory.");

        if(args.type == SellType.HELD) {
            player.sendMessage("Removing " + player.getItemInHand().getAmount() + " items from the player's hand.");
            player.setItemInHand(null);
        }
        else {

            final Material material = Material.matchMaterial(args.item);
            if(material == null) {
                // invalid material name
                return false;
            }

            // Removes all items of this material from the player's inventory.
            player.sendMessage("Removing " + getNumberOfItemsInInventory(player.getInventory(), material) + " items from the player's inventory.");
            player.getInventory().remove(material);
        }

        return true;
    }

    private int getNumberOfItemsInInventory(final Inventory inventory, final Material material) {
        int count = 0;

        for(final ItemStack itemStack : inventory.getContents()) {
            if(itemStack != null && itemStack.getType() == material) {
                count += itemStack.getAmount();
            }
        }

        return count;
    }
}