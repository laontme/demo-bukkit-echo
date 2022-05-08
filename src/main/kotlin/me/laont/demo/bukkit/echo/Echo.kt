package me.laont.demo.bukkit.echo

import me.laont.demo.bukkit.echo.command.EchoCommand
import org.bukkit.plugin.java.JavaPlugin

class Echo : JavaPlugin() {
    override fun onEnable() {
        getCommand("echo")?.setExecutor(EchoCommand(this))
    }
}