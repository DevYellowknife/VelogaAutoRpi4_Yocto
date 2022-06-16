#PV = "1.5.0+git${SRCPV}"
#SRCBRANCH = "imx_4.14.78_1.0.0_ga"
#SRCREV = "d6451cc1e162eff89b03dd63e86d55b9baa8885b"
#PLATFORM_mx8qxp  = "imx8qxp"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
    file://0001-imx8m-imx_rdc.c-fix-a-uninitialized-variable.patch \
    file://0001-Revert-Add-NXP-s-SoCs-partition-reboot-support.patch \
"

PV = "2.0+git${SRCPV}"
SRCBRANCH = "imx_4.14.98_2.3.0"
SRCREV = "bb209a0b4ccca2aa4a3a887f9606dc4a3d294adf"
PLATFORM_mx8qxp  = "imx8qx"
PLATFORM_mx8mn  = "imx8mn"

# imx-atf 1.5 uses bl31-imx8qxp.bin, 2.0 will use bl31-imx8qx.bin for a
# platform specific filename. Provide both for now, so that the user of
# the file need not care.
do_deploy_append_mx8qxp () {
    install -Dm 0644 ${S}/build/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-imx8qx.bin
    install -Dm 0644 ${S}/build/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-imx8qxp.bin
}
