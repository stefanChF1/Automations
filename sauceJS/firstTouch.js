class Monster{
    constructor(heroClass,health,mana,damage,condition){
        this.heroClass=heroClass;
        this.health=health;
        this.mana=mana;
        this.damage=damage;
        this.condition=condition;
    }
}
class LevelMonsters{
    constructor(levelNumber){
        this.levelNumber = levelNumber;
        this.monsters = [];
    }
    addMonster(monster,amount){
        for (let i=0; i < amount; i++){
        this.monsters.push(
            new Monster(
                monster.heroClass,
                monster.health,
                monster.mana,
                monster.damage,
                monster.condition
                )
            );
        }
    }
}
class Hero{
    constructor(heroClass,health,mana,damage){
        this.heroClass = heroClass;
        this.health = health;
        this.mana = mana;
        this.damage = damage;
    }
}
//heroes
const paladin = new Hero("Palladin",3000,2000,500)

//monsters for all levels
const vampire = new Monster("Vampire",1000,200,45,"aggressive");
const orc = new Monster("Wondering Orc",2000,0,50,"passive");
const werewolf = new Monster("Lone Werewolf",700,0,70,"aggressive");
const alligator = new Monster("Chilling Alligator",1500,0,33,"passive");

//levels
const level1 = new LevelMonsters(1);
level1.addMonster(werewolf, 5);
level1.addMonster(alligator, 4);

function attack(attacker,target){
    target.health -= attacker.damage;
    console.log(attacker.heroClass + " hits " + target.heroClass + " for:" + attacker.damage)
    if(target.health <= 0){
    target.health = 0;
    console.log(target.heroClass + " is dead")
}
else if (target.health <= 200) {
    console.log(target.heroClass + " Low health:" + target.health);
}
}

function attackUntilKilled(attacker,target){
while(target.health > 0){
    attack(attacker,target)
    }
}
attackUntilKilled(paladin,level1.monsters[0]);
