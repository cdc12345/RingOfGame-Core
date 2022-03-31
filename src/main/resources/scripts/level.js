--lua编写的
lv = player.getLevel()
if (lv < 100) then
    exp = (50/3)*lv^3-(25/2)*lv^2-(25/6)*lv
else
    -- -1代表永远都不会升级 ，除此之外的负数无法抑制升级
    exp = -1
end
    player.setMaxExp(exp)
