# include base image
require recipes-core/images/rpi-test-image.bb

# Set all local variables
SUMMARY = "IVI Testing Image that includes rpi-test-image"

# The resulting SDK will include the required development tools for cross-compiling a Qt application
inherit populate_sdk_qt5

inherit audio  

#Add support for ssh and tools-sdk you will find the rest in core-image class
#IMAGE_FEATURES += "ssh-server-dropbear"

#Add python3 and its packages
IMAGE_INSTALL += " python3 python3-pip python3-modules"

# IMAGE_INSTALL nano, git and rpiplay
IMAGE_INSTALL += " nano git rpiplay"

# IMAGE_INSTALL helloworld and openssh
IMAGE_INSTALL:append=" helloworld openssh openssl "

#IMAGE_FEATURES
IMAGE_FEATURES:append=" debug-tweaks dbg-pkgs"

#Add support for  OpenCV and Camera
IMAGE_INSTALL += " ffmpeg"
IMAGE_INSTALL += " gstreamer1.0 gstreamer1.0-libav gstreamer1.0-plugins-base gstreamer1.0-meta-base gstreamer1.0-plugins-bad gstreamer1.0-plugins-ugly gstreamer1.0-plugins-good"
IMAGE_INSTALL += " v4l-utils"
IMAGE_INSTALL += " userland wayland"
IMAGE_INSTALL += " weston weston-init"
MACHINE_FEATURES:append = " xf86-video-fbdev"

#Add support for wifi and bluetooth
IMAGE_INSTALL += " linux-firmware-bcm43430"

#Use network manager
#IMAGE_INSTALL += " networkmanager networkmanager-bash-completion networkmanager-nmtui"
