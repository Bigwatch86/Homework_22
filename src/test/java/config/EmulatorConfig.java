package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/emulator.properties")
public interface EmulatorConfig extends Config {
    @Key("platformName")
    String platformName();

    @Key("DeviceName")
    String DeviceName();

    @Key("PlatformVersion")
    String PlatformVersion();

    @Key("Locale")
    String Locale();

    @Key("Language")
    String Language();

    @Key("appPackage")
    String appPackage();

    @Key("AppActivity")
    String AppActivity();
}
