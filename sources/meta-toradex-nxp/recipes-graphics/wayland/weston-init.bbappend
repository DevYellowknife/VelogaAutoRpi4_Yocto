INI_UNCOMMENT_ASSIGNMENTS_append_mx8 = " \
    use-g2d=1 \
"


uncomment() {
    # already uncommented, do nothing
    if ! (grep "^$1" $2); then
        if ! (grep "^#$1" $2); then
            bbfatal "Commented setting '#$1' not found in file $2"
        fi
        sed -i -e 's,^#'"$1"','"$1"',g' $2
    fi
}
