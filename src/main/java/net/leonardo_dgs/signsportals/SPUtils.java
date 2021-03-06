package net.leonardo_dgs.signsportals;

import org.bukkit.Location;
import org.bukkit.World;

final class SPUtils {

    static Location deserializeLocation(String text, float yaw, float pitch) {
        final String[] args = text.split(" ");
        final World world = SignsPortals.getWorld(Integer.parseInt(args[0]));
        return new Location(world, Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), yaw, pitch);
    }

    static Location deserializeLocation(String text) {
        return deserializeLocation(text, 0, 0);
    }

    static String serializeLocation(Location loc) {
        int worldId = SignsPortals.getWorldId(loc.getWorld().getUID());
        if (worldId == 0)
            return null;
        return worldId + " " + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ();
    }

    static Location getRoundedLocation(Location loc) {
        int x = loc.getBlockX();
        int y = (int) Math.round(loc.getY());
        int z = loc.getBlockZ();
        return new Location(loc.getWorld(), x + 0.5D, y, z + 0.5D, loc.getYaw(), loc.getPitch());
    }

}
