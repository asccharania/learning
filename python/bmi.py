def BMI(weight,height):
	'prints BMI report'
	index =(weight * 703)/height**2
	if index < 18.5: 
		print('Underweight')
	elif index < 25.0:
		print('Normal')
	else: # index >= 25.0 
		print('Overweight')
