FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
    file://defconfig \
"

SRC_URI_append_colibri-imx8x-v10b = " \
   file://0001-Revert-ARM64-dts-apalis-imx8x-remove-no-1-8-v-from-s.patch \
   file://0002-Revert-ARM64-dts-colibri-imx8x-remove-no-1-8-v-from-.patch \
"

SRC_URI_append_apalis-imx8x-v11a = " \
   file://0001-Revert-ARM64-dts-apalis-imx8x-remove-no-1-8-v-from-s.patch \
   file://0002-Revert-ARM64-dts-colibri-imx8x-remove-no-1-8-v-from-.patch \
"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

inherit toradex-kernel-localversion
# Make sure to override LOCALVERSION in linux-imx.inc
LOCALVERSION = "-${TDX_VERSION}"
PV_append = "+git${SRCPV}"

SRCREV = "62ad468b31075ae8e77414ce506acd30b380b5d5"
SRCBRANCH = "toradex_4.14-2.3.x-imx"
SRCREV_use-head-next = "${AUTOREV}"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
