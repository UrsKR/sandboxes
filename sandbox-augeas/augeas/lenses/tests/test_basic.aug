module Test_basic =

let category = "[naMe me]\n"
test Basic.category get category = {"naMe me"}

test Basic.shortcut_key get "-_{a_b-}0" = { "-_{a_b-}0" }

test Basic.keys get "Ctrl Alt R ä" = {"key" = "Ctrl"} {"key" = "Alt"}{"key"= "R"} {"key"= "ä"}

test Basic.try get "Meta+Ctrl+Alt+Shift+Space+F1+F12+Ö" =
                    {"key"= "Meta"}
                    {"key"= "Ctrl"}
                    {"key"= "Alt"}
                    {"key"= "Shift"}
                    {"key"= "Space"}
                    {"key"= "F1"}
                    {"key"= "F12"}
                    {"key"= "Ö"}


test Basic.try get "R" = {"key"="R"}