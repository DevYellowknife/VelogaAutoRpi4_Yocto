IMAGE_CLASSES += "image_type_tezi"
IMAGE_FSTYPES += "teziimg"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
TORADEX_PRODUCT_IDS = "0039"
TORADEX_FLASH_TYPE = "emmc"

MACHINE_NAME = "Colibri-iMX7-eMMC"

MACHINEOVERRIDES_append_upstream = ":use-mainline-bsp"

MACHINE_BOOT_FILES = "boot.scr"
IMAGE_BOOT_FILES_append = " ${MACHINE_BOOT_FILES}"
WKS_FILE_DEPENDS_append = " u-boot-distro-boot"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex-rt"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp_preempt-rt = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/dtb_use-mainline-bsp = "device-tree-overlays-mainline"

KERNEL_DEVICETREE_use-mainline-bsp = " \
    imx7d-colibri-emmc-aster.dtb imx7d-colibri-emmc-eval-v3.dtb \
"
