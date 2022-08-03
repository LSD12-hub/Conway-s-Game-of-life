# Conway-s-Game-of-life.

I was really excited to work on this one. In the past I had attempted you build `Conway's Game of Life`,
but to no avail until now.

## What is Conway's Game of Life.

`Definition` - a collection of cells arranged in a grid of specified shape, such that each cell changes state as a function of time, according to a defined set of rules driven by the states of neighboring cells.

NB: This is a definition I found on google. Just type in celluar Automata.

`Explaination` - So bascially we have a grid of cells. Each cell depends on it neighbouring cells. There is a set of rules they follow.

## Rules of the game.

`if the cell is alive`
- if the cell has < 2 neigbours it dies because of under population.
- if the cell has exactly 2 or 3 neighbours it makes it to the next generation.
- if the cell has > 3 neigbours it dies because of over population.

`if the cell is dead`
- if the cell has exaclty 3 neighbours it comes alive

## How to use.
- `SPACE BAR` - pause and play simulation 
- `C` - to clear the screen
- `R` - reset or populate the world
- `Q` - to exit the program
