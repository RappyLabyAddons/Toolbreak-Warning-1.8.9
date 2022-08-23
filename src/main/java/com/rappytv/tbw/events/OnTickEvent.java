package com.rappytv.tbw.events;

import com.rappytv.tbw.ToolBreakWarning;
import com.rappytv.tbw.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class OnTickEvent {

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if(!ToolBreakWarning.enabled) return;
        if(Minecraft.getMinecraft().thePlayer == null) return;
        EntityPlayer p = Minecraft.getMinecraft().thePlayer;
        ItemStack i = p.getHeldItem();

        if(i == null) return;
        if(!i.isItemStackDamageable()) return;
        if(p.capabilities.isCreativeMode) return;

        if(Util.isSword(i)) {
            Util.swordUsed(i);
        }
        if(Util.isPickaxe(i)) {
            Util.pickaxeUsed(i);
        }
        else if(Util.isAxe(i)) {
            Util.axeUsed(i);
        }
        else if(Util.isShovel(i)) {
            Util.shovelUsed(i);
        }
    }
}