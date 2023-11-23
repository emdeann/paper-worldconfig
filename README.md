# World Configuration
Allows very basic config options for MC minigames. Currently supports adding spawn locations and chest locations - think Skywars or Survival Games.

## Usage
Once added, the plugin is super simple. Load into the map you will play your game on, then:
- Placing a chest will add a chest spawn to that location
- Placing a gold block will add a player spawn to that location

It is fine to remove blocks after placing them; the locations are saved.

Once everything is to your liking, use `/build`. This will store all the chest and spawn locations in the plugin's config file `plugins/MCWorldConfig/config.yml`. This command also clears the currently saved locations, so you can redo the locations if needed.

See `GameManager#parseLocations` in the [Skywars Plugin](https://github.com/emdeann/paper-skywars) for an example of how to use the generated config.yml files
