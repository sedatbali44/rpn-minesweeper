# rpn-minesweeper
 rpn and minesweeper


 # RPN Calculator
 post :  http://localhost:8080/api/calculate
 input :
 {
    "expression": "20 5 /"
 }
 output :
 {
    "result": 4.0
}


#  Minesweeper
post :  http://localhost:8080/api/show-hints
input : 
{
   "square": ["**...",".....",".*..."]
}
output : 
{
    "hints": [
        "**100",
        "33200",
        "1*100"
    ]
}
       
