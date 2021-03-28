load("//tools/bzl:plugin.bzl", "gerrit_plugin")

gerrit_plugin(
    name = "gerrit-random",
    srcs = glob(["java/**/*.java"]),
    manifest_entries = [
        "Gerrit-PluginName: gerrit-random",
        "Gerrit-SshModule: com.googlesource.gerrit.plugins.random.SshModule",
    ],
    deps = ["gerrit-random-api-neverlink"],
)

java_library(
    name = "gerrit-random-api-neverlink",
    neverlink = True,
    exports = ["//plugins/gerrit-random-api"],
)
