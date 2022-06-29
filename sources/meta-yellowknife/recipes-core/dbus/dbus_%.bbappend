do_install_append() {
    sed -i "/<busconfig><\/busconfig>/d" ${D}${sysconfdir}/dbus-1/system.conf
    echo "<busconfig>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "  <policy user=\"root\">" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "    <allow own=\"*\"/>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "    <allow send_interface=\"co.kr.veloga.appmanager\"/>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "    <allow send_interface=\"co.kr.veloga.messaging\"/>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "    <allow send_interface=\"co.kr.veloga.vehicle\"/>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "    <allow send_interface=\"co.kr.veloga.connection\"/>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "    <allow send_interface=\"co.kr.veloga.wifi\"/>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "  </policy>" >> ${D}${sysconfdir}/dbus-1/system.conf
    echo "</busconfig>" >> ${D}${sysconfdir}/dbus-1/system.conf
}