# Give fw_setenv mmcblkXboot0 write permissions
fw_setenv() {
    echo 0 > /sys/block/mmcblk2boot0/force_ro
    /sbin/fw_setenv "$@"
    echo 1 > /sys/block/mmcblk2boot0/force_ro
}
