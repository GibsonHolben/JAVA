import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Used to handel the action events (buttons)
 * @author CTEHolbenG46
 * @version 0.1.7
 */
public class EventHandler implements ActionListener
{
	/**
	 * A referance to the settings 
	 */
	public Settings Settings;

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			//Plays the click sfx if settings allow
			try
			{
				if(MainGameLoop.Settings[3].equals("true"))
				{
					MainGameLoop.Frame.PlayClick();
				}
			}
			catch (Exception e2)
			{
				
			}
			
			
			//Resets the game and plays again
			if(e.getSource().equals(MainGameLoop.Frame.Reset))
			{
				try
				{
					for(int i = 0; i < MainGameLoop.Frame.Buttons.length; i++)
					{
						MainGameLoop.Frame.Buttons[i].removeActionListener(this);
					}
					for(int i = 1; i < MainGameLoop.Frame.CardButtons.length; i++)
					{
						try
						{
							MainGameLoop.Frame.CardButtons[i].removeActionListener(this);
						}
						catch(Exception exception)
						{
						}
						
					}
					MainGameLoop.Frame.dispose();
					MainGameLoop.Frame.Reset.removeActionListener(this);	
					MainGameLoop.game();
					MainGameLoop.isRunning = true;
					MainGameLoop.Frame.Panel.doneOnce = false;
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
			
			}
			
			//Card click buttons
			for(int i = 0; i < MainGameLoop.Frame.CardButtons.length; i++)
			{
				if(e.getSource().equals(MainGameLoop.Frame.CardButtons[i]))
				{
					if(MainGameLoop.CurentPlayer.MyDeck.Cards.size() <= 9)
					{
						try
						{
							System.out.println("Card is: " + MainGameLoop.CurentPlayer.MyDeck.Cards.get(i));
							MainGameLoop.CurentPlayer.Play(i);
							
						}
						catch(Exception exception)
						{
							System.out.println("No card to click");
						}
					}
					else
					{
						try
						{
							System.out.println("Card is: " + MainGameLoop.CurentPlayer.MyDeck.Cards.get(i + MainGameLoop.CurentPlayer.MyDeck.Cards.size() - 9 - 1));
							MainGameLoop.CurentPlayer.Play(i + MainGameLoop.CurentPlayer.MyDeck.Cards.size() - 9 - 1);
							
						}
						catch(Exception exception)
						{
							System.out.println("No card to click");
						}
					}
					
				
				}
			}
	
			//Closes the game
			if(e.getSource().equals(MainGameLoop.Frame.Close))
			{
				//Exit the game
				System.exit(0);
				System.out.println("End");
			}
	
			//Player select buttons
			if(e.getSource().equals(MainGameLoop.Frame.P2))
			{
				FileManager.ChangePlayers("2");
				MainGameLoop.Frame.P2.setVisible(true);
				MainGameLoop.Frame.setVisible(true);
				MainGameLoop.Frame.ResetPlayerButtons(MainGameLoop.Frame.P2);
			}
			if(e.getSource().equals(MainGameLoop.Frame.P3))
			{
				FileManager.ChangePlayers("3");
				MainGameLoop.Frame.P3.setVisible(true);
				MainGameLoop.Frame.setVisible(true);
				MainGameLoop.Frame.ResetPlayerButtons(MainGameLoop.Frame.P3);
			}
			if(e.getSource().equals(MainGameLoop.Frame.P4))
			{
				FileManager.ChangePlayers("4");
				MainGameLoop.Frame.P4.setVisible(true);
				MainGameLoop.Frame.setVisible(true);
				MainGameLoop.Frame.ResetPlayerButtons(MainGameLoop.Frame.P4);
			}
	
	
			//Flip through hand buttons
			if(e.getSource().equals(MainGameLoop.Frame.FlipCurentHand))
			{
				MainGameLoop.FlipCurentHand();
				MainGameLoop.Frame.setVisible(true);
			}
			if(e.getSource().equals(MainGameLoop.Frame.FlipCurentHandBack))
			{
				MainGameLoop.FlipCurentHandBack();
				MainGameLoop.Frame.setVisible(true);
			}
	
			
			//Checks if you can use the these button
			if(MainGameLoop.Frame.canPlay)
			{
				//Skip turn
				if(e.getSource().equals(MainGameLoop.Frame.SkipTurn))
				{
					MainGameLoop.CurentPlayer.Skip();
					MainGameLoop.Frame.SkipTurn.setVisible(true);
					MainGameLoop.Frame.setVisible(true);
	
				}
				
				//Start the game
				if(e.getSource().equals(MainGameLoop.Frame.Start))
				{
					Setup.InitGame();
					MainGameLoop.Start();
					MainGameLoop.Frame.Start.setVisible(true);
					MainGameLoop.Frame.setVisible(true);
				}
				
				//Plays the active card in the active players hand
				if(e.getSource().equals(MainGameLoop.Frame.Play))
				{
					
					MainGameLoop.isGameStarted = true;
					MainGameLoop.CurentPlayer.Play(0);
					MainGameLoop.Frame.setVisible(true);
					MainGameLoop.Frame.Play.setVisible(true);
				}
	
			}
			else
			{
				//Wild card buttons
				if(e.getSource().equals(MainGameLoop.Frame.Red))
				{
					MainGameLoop.CurentColor = Settings.ColorsBackup[0];
					MainGameLoop.Frame.canPlay = true;
					System.out.println(MainGameLoop.CurentColor);
					MainGameLoop.NextPlayer();
					MainGameLoop.Frame.SettupColorButtons(-1000);
					MainGameLoop.Frame.Red.removeActionListener(this);
				}
				if(e.getSource().equals(MainGameLoop.Frame.Blue))
				{
					MainGameLoop.CurentColor = Settings.ColorsBackup[1];
					MainGameLoop.Frame.canPlay = true;
					MainGameLoop.NextPlayer();
					MainGameLoop.Frame.SettupColorButtons(-1000);
					MainGameLoop.Frame.Blue.removeActionListener(this);
				}
				if(e.getSource().equals(MainGameLoop.Frame.Green))
				{
					MainGameLoop.CurentColor = Settings.ColorsBackup[2];
					MainGameLoop.Frame.canPlay = true;
					MainGameLoop.NextPlayer();
					MainGameLoop.Frame.SettupColorButtons(-1000);
					MainGameLoop.Frame.Green.removeActionListener(this);
				}
				if(e.getSource().equals(MainGameLoop.Frame.Yellow))
				{
					MainGameLoop.CurentColor = Settings.
										ColorsBackup[3];
					MainGameLoop.Frame.canPlay = true;
					MainGameLoop.NextPlayer();
					MainGameLoop.Frame.SettupColorButtons(-1000);
					MainGameLoop.Frame.Yellow.removeActionListener(this);
				}
			}
	
			//How to play button
			if(e.getSource().equals(MainGameLoop.Frame.HowToPlay))
			{
				FileManager.ShowHowToPlay();
			}
			
			//Shows the settings menu
			if(e.getSource().equals(MainGameLoop.Frame.SettingsButton))
			{
				//FileManager.ShowSettings();
				Settings = new Settings();
			}
		}
		catch(Exception error)
		{
			System.out.println("MyFrame Button");
			error.printStackTrace();
		}


		//Settings ******************************

		try
		{
			if(Settings.doneOnce)
			{
				//Resets the settings
				if(e.getSource().equals(Settings.Reset))
				{
					JOptionPane.showMessageDialog(Settings,"Settings will be overwriten, please restart the game");
					Setup.FixColors();
					
				}
				
				//SFX settings toggle
				if(e.getSource().equals(Settings.SfxToggle))
				{
					Settings.ChangeSfx();
					Settings.SaveSettings();
				}
				if(e.getSource().equals(Settings.GenerateLog))
				{
					FileManager.GenerateLogs();
					JOptionPane.showMessageDialog(Settings, "Log has been generated");
				}
				
				//Submits the wild card draw size settings
				if(e.getSource().equals(Settings.SubmitWildCardSize))
				{
					if(Settings.SubmitSetting("Wild"))
					{
						JOptionPane.showMessageDialog(Settings,
								"Wild card Settings accepted, "
								+ "Please restart the game for "
								+ "changed to take effect");
						Settings.WildCardDrawCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[1]) - 1);
						Settings.SaveSettings();
					}
					else
					{
						JOptionPane.showMessageDialog(Settings,
								"Invalid number for wild card draw (1-9) "
										+ "is accepted... "
										+ "Refactoring to default...");
						Settings.WildCardDrawCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[1]) - 1);
						Settings.SaveSettings();
					}

				}
				
				//Submits the deck size setting 
				if(e.getSource().equals(Settings.SubmitDeckSize))
				{
					if(Settings.SubmitSetting("Deck"))
					{
						JOptionPane.showMessageDialog(Settings,
								"Settings accepted, Please restart the "
										+ "game for changed to take effect");
						Settings.DeckSizeCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[2]) - 1);
						Settings.SaveSettings();

					}
					else
					{
						JOptionPane.showMessageDialog(Settings,
								"Invalid number for deck size (4-99) is"
										+ " accepted... Refactoring to default...");
						Settings.DeckSizeCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[2]) - 1);
						Settings.SaveSettings();
					}

				}

				//Submits the color settings 
				if(e.getSource().equals(Settings.SubmitColors))
				{
					System.out.println("Saved colors " + MainGameLoop.Settings[0]);
					MainGameLoop.Settings[0] = 
							Settings.Color1Combo.getSelectedItem() + "," +
							Settings.Color2Combo.getSelectedItem() + "," +
							Settings.Color3Combo.getSelectedItem() + "," +
							Settings.Color4Combo.getSelectedItem() + ",";
					
					MainGameLoop.Settings[4] = 
							(String) Settings.ColorBackground.getSelectedItem();
					JOptionPane.showMessageDialog(Settings,
							"Color Settings accepted, Please restart "
									+ "the game for changed to take effect");
					Settings.SaveSettings();
					Visuals.UpdateGraphicsFlip();
					Visuals.UpdateGraphicsPlayer();
					Settings.dispose();
				}


				
			}
			else
			{
				Settings.doneOnce = true;
			}
		}
		catch(Exception ignored)
		{
		}
		
	}

}
