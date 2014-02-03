package dougrich.dev.mc.hermes.commands;

public class ShopHelpExecutor extends ShopBaseCommandExecutor {

	protected boolean HandleCommand(ShopExecutorArgs e) {
		String[] help = {
				"----MC-Hermes Help----",
				"/shop help: displays shop message",
				"/shop sell <held|minecraft:id>: adds an item to circulation",
				"/shop list: lists items for sale",
				"/shop buy <minecraft:id>: attempts to buy from your purse",
				"/shop purse: gives information about your purse"
		};
		e.sender.sendMessage(help);
		return true;
	}
}
