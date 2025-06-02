package chai.divinen;

import chai.divinen.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivineEncounters implements ModInitializer {
	public static final String MOD_ID = "divinen";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initializeItems();
	}
}