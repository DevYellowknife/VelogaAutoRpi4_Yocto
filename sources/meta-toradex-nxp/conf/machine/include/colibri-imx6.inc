IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES += "teziimg"
TORADEX_PRODUCT_IDS = "0014 0015 0016 0017"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
OFFSET_SPL_PAYLOAD = "138"

MACHINE_NAME = "Colibri-iMX6"

MACHINEOVERRIDES_append_upstream = ":use-mainline-bsp"

MACHINE_BOOT_FILES = "boot.scr"
IMAGE_BOOT_FILES_append = " ${MACHINE_BOOT_FILES}"
WKS_FILE_DEPENDS_append = " u-boot-distro-boot"

KERNEL_IMAGETYPE_${MACHINE} = "zImage"
KERNEL_DEVICETREE += "imx6dl-colibri-iris.dtb imx6dl-colibri-iris-v2.dtb"
PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex-rt"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp_preempt-rt = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/dtb_use-mainline-bsp = "device-tree-overlays-mainline"

UBOOT_SUFFIX = "img"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

# As per meta-freescale commit 927b31771dab ("xf86-video-imx-vivante: Remove fb
# from name") this package got renamed. Use new one!
XSERVER_DRIVER_colibri-imx6 = "xf86-video-imx-vivante"
