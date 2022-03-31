//经验计算
val level = mob.getLevel();
if (level == 100){
    mob.setMaxExp(-1);
} else {
    mob.setMaxExp(20*Math.pow(10,level));
}
