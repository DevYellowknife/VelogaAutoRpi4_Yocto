FILESEXTRAPATHS_prepend := "${THISDIR}/qtmultimedia/:"

SRC_URI_append_apalis-imx8 += " \
    file://vivante_remap_video_buffer_each_time.patch \
"

#make this machine specific
PACKAGE_ARCH_append_apalis-imx8 = "${MACHINE_ARCH}"
