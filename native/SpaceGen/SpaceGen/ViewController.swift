//
//  ViewController.swift
//  SpaceGen
//
//  Created by Phil Mitchell on 12/20/19.
//  Copyright © 2019 GenUI. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = CommonKt.createApplicationScreenMessage()
        view.addSubview(label)

        let settingsManager = SettingsManager(context: ApplicationContext())
        let storedUsername = settingsManager.getUsername()
        print("STORED: \(String(describing: storedUsername))")

        let username = "joey"
        settingsManager.saveUsername(name: username)

    }


}

