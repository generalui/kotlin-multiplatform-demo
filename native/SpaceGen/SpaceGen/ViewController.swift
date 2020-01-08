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

    @IBOutlet weak var label: UILabel! {
        didSet {
            label.font = UIFont.preferredFont(forTextStyle: .title2)
            label.adjustsFontSizeToFitWidth = true
        }
    }

    @IBOutlet weak var spinner: UIActivityIndicatorView!

    override func viewDidLoad() {
        super.viewDidLoad()

        label.text = CommonKt.createApplicationScreenMessage()

        spinner.startAnimating()
        let service = NasaApiService(api: NasaApi())
        let yesterday = getYesterdayDate() ?? Date()
        service.getPictureOfDay(date: yesterday) { [weak self] pod, error in
            if let pod = pod {
                self?.label.text = pod.title
            }
            if let error = error {
                self?.label.text = "\(error)"
            }
            self?.spinner.stopAnimating()
        }

    }

    private func getYesterdayDate() -> Date? {
        let now = Date()
        let components = DateComponents(calendar: Calendar.current, day: -1)
        return Calendar.current.date(byAdding: components, to: now)
    }

}
