# Triibu Mod

A Minecraft mod made to access world data from an API 

## How to start the API

1. Start Minecraft with the mod
2. Load into a world
3. API opens on port: 8080

## How to use the API

### The API supports 2 types of GET requests:

- Block - specific block at x, y, z  
  - Example: `http://localhost:8080/world/block?x=1&y=56&z=3` will output `minecraft:stone`
    
- Slab - 3D area with start x,y,z and end x,y,z  
  - End coordinates > Start coordinates  
  - If a block is air, it won't send `minecraft:air`  
  - If one of the blocks is outside the buildable world, it won't respond for that block
    
    - Example: `http://localhost:8080/world/slab?xStart=0&yStart=40&zStart=0&xEnd=1&yEnd=42&zEnd=1`  
      Output:
      ```
      0,40,0,minecraft:stone
      1,40,0,minecraft:stone
      1,40,1,minecraft:stone
      1,41,1,minecraft:stone
      1,42,1,minecraft:water
      ```

## Further development
- [ ] Add block setting function
- [ ] Make "Slab" coordinates work even if End < Start
- [ ] Make the "Slab" response more efficient
