include recipes-qt/images/b2qt-embedded-qt5-image.bb

SUMMARY =  "Veloga Auto Image - for raspi4"

LICENSE = "MIT"

inherit features_check populate_sdk_qt5
IMAGE_INSTALL += "\
    cinematicexperience \
    protobuf \
"
IMAGE_INSTALL_remove = "\
"

TOOLCHAIN_HOST_TASK_append += " nativesdk-protobuf-dev "

set_board_env(){
    mkdir -p ${IMAGE_ROOTFS}/etc/profile.d
    echo "export QT_QPA_FONTDIR=/usr/share/fonts" >> ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh
    echo "export QT_QPA_PLATFORM=eglfs" >> ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh
    echo "export QT_QPA_PLATFORM_PLUGIN_PATH=/usr/lib/plugins/platforms" >> ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh
    echo "export LD_LIBRARY_PATH=/usr/lib" >> ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh

    chmod 755 ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh
}

ROOTFS_POSTPROCESS_COMMAND += "set_board_env;"
