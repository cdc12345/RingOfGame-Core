//经验计算
val level = mob.getLevel();
function level(){
    if (level == 100){
        return -1;
    } else {
        return 20*Math.pow(10,level));
    }
}
level();