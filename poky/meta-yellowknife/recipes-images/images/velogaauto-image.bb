require recipes-core/images/rpi-basic-image.bb

SUMMARY =  "Veloga Auto Image - for raspi4"

LICENSE = "MIT"

IMAGE_FEATURES += "ssh-server-dropbear splash hwcodecs"

inherit features_check populate_sdk_qt5

SPLASH = "psplash-raspberrypi"

IMAGE_INSTALL += "\
    kernel-modules \
    qtbase \
    qtbase-plugins \
    qtbase-tools \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsvg \
    qtsvg-plugins \
    qtsensors \
    qtserialbus \
    qtserialport \
    qtimageformats-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtscript \
    qt3d \
    qt3d-qmlplugins \
    qt3d-tools \
    qtgraphicaleffects-qmlplugins \
    qtconnectivity \
    qtconnectivity-dev \
    qtconnectivity-mkspecs \
    qtconnectivity-qmlplugins \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtquickcontrols2 \
    fontconfig \
    iw \
    wpa-supplicant \
    bluez5 \
    protobuf \
    ${MACHINE_EXTRA_RRECOMMENDS} \
"

IMAGE_INSTALL_remove = "\
    qt5-opengles2-test \
"

RDEPENDS_${PN} = "perl"

set_board_env(){
    mkdir -p ${IMAGE_ROOTFS}/etc/profile.d
    echo "export QT_QPA_FONTDIR=/usr/lib/fonts" >> ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh
    echo "export QT_QPA_PLATFORM_PLUGIN_PATH=/usr/lib/plugins/platforms" >> ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh
    echo "export QT_PLUGIN_PATH=/usr/lib/plugins" >> ${IMAGE_ROOTFS}/etc/profile.d/set_board_env.sh
}

ROOTFS_POSTPROCESS_COMMAND += "set_board_env;"
