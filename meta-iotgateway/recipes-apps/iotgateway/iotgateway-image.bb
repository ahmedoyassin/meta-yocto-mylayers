require /home/yasso/yocto/poky/meta/recipes-core/images/core-image-minimal.bb

SUMMARY = "IoT Gateway Custom Image"
DESCRIPTION = "Custom image recipe for an IoT gateway"

# Custom banner or other message
IMAGE_BANNER = "IoT Gateway Image"

RDEPENDS:${PN}:append = " qtbase-tools qtbase qtdeclarative qtimageformats qtmultimedia qtquickcontrols2 qtquickcontrols qtbase-plugins liberation-fonts qtwayland openssl"
DEPENDS:append = " qtbase"


SRC_URI = "file://iotgateway.cpp"
S = "${WORKDIR}/git"

inherit core-image
inherit autotools
inherit systemd
inherit qmake5


IMAGE_INSTALL += "\
    htop \
    iotop \
    systemd \
    collectd \
    nano \
    packagegroup-core-ssh-openssh \
    openssh-sftp-server \
    qttools \
    "
MACHINE_FEATURES += "\
    wifi \
    qvga \
    "

# Core packages and utilities
IMAGE_INSTALL += "\
    busybox \
    python3 \
    python3-pip \
    openssl \
    curl \
    "

# Wi-Fi support
IMAGE_INSTALL += " \
    linux-firmware \
    linux-firmware-rtl8192cu \
    wpa-supplicant \
    iw \
    "


# Include additional layers or configurations
IMAGE_INSTALL += " \
    kernel-modules \
    iptables \
    "

EXTRA_IMAGE_FEATURES += " ptest-pkgs"

# Custom configurations
IMAGE_ROOTFS_EXTRA_SPACE = "1048576"
IMAGE_FSTYPES = "ext4 tar.bz2"



# Specify the image type
IMAGE_TYPE = "iotgateway"

# Define default user credentials (for example)
EXTRA_USERS_PARAMS = "usermod -P your_password root;"


# Set the bootloader
IMAGE_BOOTLOADER = "u-boot"

