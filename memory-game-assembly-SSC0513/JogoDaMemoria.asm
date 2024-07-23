jmp main



main:
	start:
		
		loadn r7, #48; r7 é a pontuação
		
		call ApagaPontos; Apaga os pontos da Tela
		call ApagaTela; Apaga tudo que está na tela
		
		call InitialMsg; Tela inicial do jogo
		call WaitPress; Espera pelo aperto do "espaço para progredir"
		call ApagaTela; Apaga tudo que está na tela
		
		call IntroMsg; Mensagem introdutória
		call WaitPress
		
		reset:
			
			call ApagaTela; Apaga tudo que está na tela
			call PrintPontos; Inicializa os pontos na tela
			
			;-----------------------        Nível 1
			call Nvl1Msg
			call Nvl1Reader
			call IncremetaPontos; Incrementa os pontos
			
			call ApagaTela; Apaga tudo que está na tela
			
			;-----------------------        Nível 2
			call Nvl2Msg
			call Nvl2Reader
			call IncremetaPontos; Incrementa os pontos
			
			call ApagaTela; Apaga tudo que está na tela
			
			;-----------------------        Nível 3
			call Nvl3Msg
			call Nvl3Reader
			call IncremetaPontos; Incrementa os pontos
			
			call WIN
			end:
				call RestartReader; Aguarda apertar "espaço" para recomeçar o jogo
			

WIN:
	call ApagaTela; Apaga tudo que está na tela
	call WinMsg; Mensagem de vitória
	call RestartReader; Aguarda apertar "espaço" para recomeçar o jogo

LOSS:
	call ApagaTela; Apaga tudo que está na tela
	call LossMsg; Mensagem de derrota
	jmp end
	

	
;
;
;
;---------------------------	
;Print Functions
;
Print:
	push r0	; protege o r0 na pilha para preservar seu valor
	push r1	; protege o r1 na pilha para preservar seu valor
	push r2	; protege o r1 na pilha para preservar seu valor
	push r3	; protege o r3 na pilha para ser usado na subrotina
	push r4	; protege o r4 na pilha para ser usado na subrotina
	
	loadn r3, #'\0'	; Criterio de parada

PrintLoop:	
	loadi r4, r1
	cmp r4, r3
	jeq PrintOut
	add r4, r2, r4
	outchar r4, r0
	inc r0
	inc r1
	jmp PrintLoop

PrintOut:	
	pop r4
	pop r3
	pop r2
	pop r1
	pop r0
	rts


;
;
;
;---------------------------	
;Points Functions
;

StringPontos: string "Pontos: "

PrintPontos:; Imprime os pontos na tela
	loadn r0, #8
	loadn r2, #2816
	add r7, r7, r2
	outchar r7, r0

	loadn r0, #0
	loadn r1, #StringPontos
	loadn r2, #0
	call Print
	
	rts
	
ApagaPontos:; Apaga os pontos na tela
	loadn r0, #0
	loadn r1, #StringApagaPontos
	loadn r2, #0
	call Print
	
	rts
	
StringApagaPontos: string "                                       "
	
IncremetaPontos:; Incrementa os pontos e imprime na tela
	inc r7
	call PrintPontos
	rts
;
;
;
;---------------------------	
; Message Functions
;
InitialMsg:; Mensagem inicial
	loadn r0, #160
	loadn r1, #StringJogo
	loadn r2, #0
	call Print
	
	loadn r0, #440
	loadn r1, #StringDaMaisAcento
	loadn r2, #0
	call Print
	
	loadn r0, #680
	loadn r1, #StringMemoria
	loadn r2, #2816
	call Print
	
	loadn r0, #1005
	loadn r1, #StringPressSpaceToStart
	loadn r2, #1536
	call Print
	
	rts

IntroMsg:; Mensagem introdútória
	loadn r0, #160
	loadn r1, #StringIntro
	loadn r2, #0
	call Print
	
	loadn r0, #1004
	loadn r1, #StringPressSpaceToContinue
	loadn r2, #1536
	call Print

	rts

LossMsg:
	loadn r0, #160
	loadn r1, #StringLoss
	loadn r2, #0
	call Print
	
	loadn r0, #1004
	loadn r1, #StringPressSpaceToRestart
	loadn r2, #1536
	call Print

	rts

WinMsg:
	loadn r0, #160
	loadn r1, #StringWin
	loadn r2, #0
	call Print
	
	loadn r0, #1004
	loadn r1, #StringPressSpaceToRestart
	loadn r2, #1536
	call Print

	rts
	
ApagaTela:
	loadn r0, #40
	loadn r1, #StringApagaTela
	loadn r2, #0
	call Print
	rts

;
;
;---------------------------	
; Wait Presses
;

WaitPress:
	WaitLoop:			; loop ate o jogador digitar algo
		loadn r1, #255	; Se nao digitar nada vem 255	
		inchar r0			; Le o teclado, se nada for digitado = 255
		cmp r0, r1			;compara r0 com 255
		jeq WaitLoop	; Fica lendo ate' que digite uma tecla 
		call BtnReader
	rts

GPress:
	GPressLoop:
		loadn r1, #255	; Se nao digitar nada vem 255	
		inchar r0			; Le o teclado, se nada for digitado = 255
		cmp r0, r1			;compara r0 com 255
		jeq GPressLoop	; Fica lendo ate' que digite uma tecla 
		call GPressReader
	rts
	
RPress:
	RPressLoop:
		loadn r1, #255	; Se nao digitar nada vem 255	
		inchar r0			; Le o teclado, se nada for digitado = 255
		cmp r0, r1			;compara r0 com 255
		jeq RPressLoop	; Fica lendo ate' que digite uma tecla 
		call RPressReader
	rts
	
BPress:
	BPressLoop:
		loadn r1, #255	; Se nao digitar nada vem 255	
		inchar r0			; Le o teclado, se nada for digitado = 255
		cmp r0, r1			;compara r0 com 255
		jeq BPressLoop	; Fica lendo ate' que digite uma tecla 
		call BPressReader
	rts

RestartPress:
	RestartLoop:
		loadn r1, #255	; Se nao digitar nada vem 255	
		inchar r0			; Le o teclado, se nada for digitado = 255
		cmp r0, r1			;compara r0 com 255
		jeq RestartLoop	; Fica lendo ate' que digite uma tecla 
		call RestartReader
	
;
;
;
;---------------------------	
; Readers
;
BtnReader:
	SpacePress:
		loadn r1, #32; /space
		cmp r1, r0
		jne WaitLoop
		rts

GPressReader:
	GPressDetect:
		loadn r1, #103; /g
		cmp r1, r0
		jne WrongAnswer
		rts
		
	WrongAnswer:
		call LOSS
		
RPressReader:
	RPressDetect:
		loadn r1, #114; /r
		cmp r1, r0
		jne WrongAnswer
		rts
		
	WrongAnswer:
		call LOSS
		
BPressReader:
	BPressDetect:
		loadn r1, #98; /b
		cmp r1, r0
		jne WrongAnswer
		rts
		
	WrongAnswer:
		call LOSS

RestartReader:
	SpacePress:
		loadn r1, #32; /space
		cmp r1, r0
		jne RestartLoop
		jmp start
;
;
;
;---------------------------	
; Level Building
;

Nvl1Msg:

	loadn r0, #1004
	loadn r1, #StringPressSpaceToContinue
	loadn r2, #0
	call Print

	loadn r0, #160
	loadn r1, #StringBlock3
	loadn r2, #2304
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock4
	loadn r2, #512
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock5
	loadn r2, #3072
	call Print

	call WaitPress

	call ApagaTela

	rts

Nvl2Msg:

	loadn r0, #1004
	loadn r1, #StringPressSpaceToContinue
	loadn r2, #0
	call Print
	
	call WaitPress

	loadn r0, #160
	loadn r1, #StringBlock2
	loadn r2, #512; green
	call Print

	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock3
	loadn r2, #2304; red
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock4
	loadn r2, #512; green
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock5
	loadn r2, #3072; blue
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock6
	loadn r2, #2304; red
	call Print

	call WaitPress

	call ApagaTela

	rts
	
Nvl3Msg:

	loadn r0, #1004
	loadn r1, #StringPressSpaceToContinue
	loadn r2, #0
	call Print
	
	call WaitPress

	loadn r0, #160
	loadn r1, #StringBlock1
	loadn r2, #3072; blue
	call Print

	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock2
	loadn r2, #2304; red
	call Print

	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock3
	loadn r2, #3072; blue
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock4
	loadn r2, #512; green
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock5
	loadn r2, #3072; blue
	call Print
	
	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock6
	loadn r2, #2304; red
	call Print

	call WaitPress
	
	loadn r0, #160
	loadn r1, #StringBlock7
	loadn r2, #512; green
	call Print

	call WaitPress


	call ApagaTela

	rts	

Nvl1Reader:; Define a leitura de botões corretas para o nível 1

	loadn r0, #160
	loadn r1, #StringQuestionMark
	loadn r2, #0
	call Print
	
	loadn r0, #800
	loadn r1, #StringPressToColor
	loadn r2, #0
	call Print
	
	call RPress
	call GPress
	call BPress

	rts
	
Nvl2Reader:;Define a leitura de botões corretas para o nível 2

	loadn r0, #160
	loadn r1, #StringQuestionMark
	loadn r2, #0
	call Print
	
	loadn r0, #800
	loadn r1, #StringPressToColor
	loadn r2, #0
	call Print
	
	call GPress
	call RPress
	call GPress
	call BPress
	call RPress

	rts
	
Nvl3Reader:;Define a leitura de botões corretas para o nível 3

	loadn r0, #160
	loadn r1, #StringQuestionMark
	loadn r2, #0
	call Print
	
	loadn r0, #800
	loadn r1, #StringPressToColor
	loadn r2, #0
	call Print
	
	call BPress
	call RPress
	call BPress
	call GPress
	call BPress
	call RPress
	call GPress

	rts
;
;
;
;---------------------------	
; String Building
;
;----  Intrucoes de Menu
StringPressSpaceToStart: string "Pressione ESPACO para comecar"

StringPressSpaceToContinue: string "Pressione ESPACO para continuar"

StringPressSpaceToRestart: string "Pressione ESPACO para recomecar"

StringPressToColor: string
"     Pressione R para vermelho(RED)    
       Pressione B para azul(BLUE)      
     Pressione G para verder(GREEN)     "
            
StringQuestionMark: string
"    ###############################    
    ############        ###########    
    ##################  ###########    
    ##################  ###########    
    ##############      ###########    
    ##############  ###############    
    ###############################    
    ##############  ###############    
    ###############################    "

;----  Tela Inicial
StringJogo : string "      ###### ###### ###### ######      
      ###### ###### ###### ######      
        ##   ##  ## ##     ##  ##      
        ##   ##  ## ##  ## ##  ##      
      ####   ###### ###### ######      
      ####   ###### ###### ######      "   

StringDaMaisAcento : string "                ##  ###                
                # # # #                
                # # ###                
                # # # #                
                ##  # #                "

StringMemoria : string "    # #  ###  # #  ###  ###  #  ###    
    ###  #    ###  # #  # #     # #    
    # #  ###  # #  # #  ###  #  ###    
    # #  #    # #  # #  ##   #  # #    
    # #  ###  # #  ###  # #  #  # #    "
    
;----  Tela Instrucoes
StringIntro: string "     MEMORIZE A SEQUENCIA DE CORES     
         QUE APARECERAO NA TELA.         "

;---- Telas Finais
StringLoss: string "              VOCE PERDEU!              "
StringWin: string "              VOCE VENCEU!              "

;----  Apaga Tela
StringApagaTela: string "
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      
                                      "

;----  Blocks - Posições de cor na tela para memorizar
StringBlock1: string
"  ####                                 
  ####                                 
  ####                                 
  ####                                 
  ####                                 
  ####                                 "
 
StringBlock2: string
"       ####                            
       ####                            
       ####                            
       ####                            
       ####                            
       ####                            "
  
StringBlock3: string
"            ####                       
            ####                       
            ####                       
            ####                       
            ####                       
            ####                       "

StringBlock4: string
"                 ####                  
                 ####                  
                 ####                  
                 ####                  
                 ####                  
                 ####                  "

StringBlock5: string
"                      ####             
                      ####             
                      ####             
                      ####             
                      ####             
                      ####             "

StringBlock6: string
"                           ####        
                           ####        
                           ####        
                           ####        
                           ####        
                           ####        "

StringBlock7: string
"                                ####   
                                ####   
                                ####   
                                ####   
                                ####   
                                ####   "