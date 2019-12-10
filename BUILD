java_library(
  name = "jeromq",
  exports = [
    "@maven//:org_zeromq_jeromq"
  ],
)

java_binary(
  name = "Server",
  srcs = ["src/main/java/addison/Server.java"],
  deps = [":jeromq"],
)

java_binary(
  name = "Client",
  srcs = glob(["src/main/java/addison/Client*.java"]),
  deps = [":jeromq"],
)