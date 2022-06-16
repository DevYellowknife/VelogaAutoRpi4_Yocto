require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-toradex-initial-env.inc
require u-boot-toradex-common_${PV}.inc

SUMMARY = "U-Boot bootloader with support for Toradex i.MX 8 series SoMs"

PROVIDES += "u-boot"
DEPENDS_append = " dtc-native"

SRC_URI_append_apalis-imx8a0 = " file://0001-Revert-apalis-imx8-fused-modules-boot-from-emmc.patch"
SRC_URI_append_use-mainline-bsp_colibri-imx8x = " file://0001-colibri-imx8x-modify-device-tree-name-for-mainline-u.patch"

BOOT_TOOLS = "imx-boot-tools"
