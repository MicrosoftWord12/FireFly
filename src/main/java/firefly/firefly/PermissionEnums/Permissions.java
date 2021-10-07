package firefly.firefly.PermissionEnums;

public enum Permissions {
//    ALLPERMS("FireFly.*"),
    FREEZE("FireFly.Freeze"),
    KICK_MEMBER("FireFly.KickMember"),
    BAN_MEMBER("FireFly.BanMember"),
    PLAYER_MOVE("FireFly.PlayerMove"),
    SEE_AVAIABLE_COMMANDS("FireFly.seeAvailableCommands"),
    GIVE("FireFly.Give"),
    INVISIBLE("FireFly.Invisible"),
    INVULNERABLE("FireFly.Invulnerable"),
    SWITCHGAMEMODE("FireFly.SwitchGamemode"),
    DB_ADMIN("FireFly.DB.Admin");
    public String name;

    private Permissions(String name){
        this.name = name;
    }

}
