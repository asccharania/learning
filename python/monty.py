print ('You approach The Bridge of Death!\nOh look that guy from scene 24!\n He is the keeper of the Bridge of Death, he asks each traveler three questions. He who answers the five questions, may cross in safety.\n If you get it wrong you are cast into the gorge of eternal peril.\n')
print('Who will answer the questions?')
hero = input ('Will you answer the Questions of the Keeper of the Bridge of Death? ')
answer = hero.lower() 
if answer == 'yes':
    print('Keeper: Stop! Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.')
    name = input('What is your name? ')
    quest = input('What is your quest? ')
    if name == 'Arthur, King of the Britons':
        swallow = input('What is the air-speed velocity of an unladen swallow? ')
        if swallow == 'What do you mean?  An African or European swallow?':
            print('What?  I don\'t know that!  Auuuuuuuugh!')
        else: print('You are Flung into the Gorge of Eternal Peril\ni.e you are dead.')
    else: color = input('What is your favorite colour? ')
    print ('Right. Off you go.')
else: print('Well go home you ninny! We have no use for cowards!') 

