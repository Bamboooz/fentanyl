<div align="center">
    <img src="https://github.com/Bamboooz/fentanyl/blob/main/src/main/resources/assets/fentanyl/icon.png?raw=true" height="192" width="192" />
    <h1>Create: Fentanyl</h1>
</div>

# Docs
## Recipes
### Syringe
<img src="https://github.com/Bamboooz/fentanyl/blob/main/src/main/resources/assets/fentanyl/docs/syringe.png?raw=true" height="192" width="192" />

### Poppy seeds
<img src="https://github.com/Bamboooz/fentanyl/blob/main/src/main/resources/assets/fentanyl/docs/poppy_seeds.png?raw=true" height="192" width="192" />

### Crushed poppy seeds
Put the poppy seeds through create mod crushing wheels

### Fentanyl liquid (bottle amount) + Tar
Put crushed poppy seeds and 1 bucket of water in the create mod mixer, heated

### Fentanyl powder
1 bucket of fentanyl liquid in the create mod mixer, superheated

### Fentanyl syringe
1 bucket of fentanyl and syringe in the create mod mixer, unheated

## Fentanyl mechanic
Each player has an NBT value "fentanyl" which indicated the amount of fentanyl in their system

| fentanyl    | effect level |
|-------------|--------------|
| 0           | no effect    |
| 1-12000     | 0            |
| 12001-24000 | 1            |
| >24000      | 2            |

| effect level | effects on the player                                  |
|--------------|--------------------------------------------------------|
| 0            | benefits, immunity to blindess, nausea, poison         |
| 1            | no benefits anymore, nausea, player model bending      |
| 2 or higher  | the debuffs above + starts to get OD damage until dies |

Each minecraft tick the fentanyl nbt value decreases by one, meaning it takes 10 minutes to decrease by one level of the fentanyl effect

## Item usages
### Fentanyl powder
RMB to use fentanyl, gives 12000 fentanyl units

### Syringe
RMB to just prick yourself, RMB on entity to prick them, RMB on ground to place the syringe, gives 0 fentanyl units on prick

### Fentanyl syringe
RMB in air to prick yourself, RMB on entity to prick them, RMB on ground places a fentanyl syringe, the first time someone steps on it they get pricked and injected with fent, gives 12000 fentanyl units

### Fentanyl fluid
Swimming in it will instantly give you 72000 units and you will OD