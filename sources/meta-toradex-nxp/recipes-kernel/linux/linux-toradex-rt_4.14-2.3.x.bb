require recipes-kernel/linux/linux-toradex_4.14-2.3.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.14-2.3.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

# patches get moved into the 'older' directory when superseeded, so provide
# both possible storage locations.
MIRRORS += "${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/ ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/"
SRC_URI += " \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/patch-4.14.170-rt75.patch.xz;name=rt-patch \
    file://0001-imx_sc_thermal-prevent-BUG-with-rt-patch.patch \
    file://0002-ddr-perf-prevent-BUG-with-rt-patch.patch \
"

SRC_URI[rt-patch.md5sum] = "7e05c603a56880a2655993d8d048b0e3"
SRC_URI[rt-patch.sha256sum] = "3e71bcbe02d47aa782503839dba4b846f4b7c5991c9eb7b75358f6c4303f50b0"
