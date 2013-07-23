module Test_basic =

let category =  "[naMe me]\n"
test Basic.category get category = {"naMe me"}

test Basic.shortcut_key get "-_{a_b-}0" = { "-_{a_b-}0" }

test Basic.keys get "Meta+Ctrl+Alt+Shift+Space+F1+F12+Ö" =
{ "key"
    {"1"= "Meta"}
    {"2"= "Ctrl"}
    {"3"= "Alt"}
    {"4"= "Shift"}
    {"5"= "Space"}
    {"6"= "F1"}
    {"7"= "F12"}
    {"8"= "Ö"}
}


(* Kill Window=Ctrl+Alt+4,Ctrl+Alt+Esc,Kill Window*)

test Basic.binding_value get "a+b+c,4+5+6,Kill Window"  =
    { "active"
        { "key"
            {"1" = "a"}
            {"2" = "b"}
            {"3" = "c"}
        }
    }
    {"default"
        { "key"
            {"1" = "4"}
            {"2" = "5"}
            {"3" = "6"}
        }
    }
    {"humanreadable" = "Kill Window"}